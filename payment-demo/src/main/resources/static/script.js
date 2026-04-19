const customerNameInput = document.getElementById("customerName");
const amountInput = document.getElementById("amount");
const methodSelect = document.getElementById("method");
const payBtn = document.getElementById("payBtn");
const resultDiv = document.getElementById("result");

document.addEventListener("DOMContentLoaded", () => {
    loadPaymentMethods();
    payBtn.addEventListener("click", makePayment);
});

async function loadPaymentMethods() {
    try {
        const response = await fetch("/api/payments/methods");
        const methods = await response.json();

        methodSelect.innerHTML = "";

        if (!response.ok || !Array.isArray(methods) || methods.length === 0) {
            methodSelect.innerHTML = `<option value="">Yöntem bulunamadı</option>`;
            return;
        }

        methodSelect.innerHTML = `<option value="">Ödeme yöntemi seçin</option>`;

        methods.forEach(method => {
            const option = document.createElement("option");
            option.value = method;
            option.textContent = formatMethodName(method);
            methodSelect.appendChild(option);
        });
    } catch (error) {
        methodSelect.innerHTML = `<option value="">Yöntemler yüklenemedi</option>`;
    }
}

async function makePayment() {
    const customerName = customerNameInput.value.trim();
    const amount = parseFloat(amountInput.value);
    const method = methodSelect.value;

    if (!customerName) {
        showError("Lütfen müşteri adını girin.");
        return;
    }

    if (!amount || amount <= 0) {
        showError("Lütfen 0'dan büyük bir tutar girin.");
        return;
    }

    if (!method) {
        showError("Lütfen bir ödeme yöntemi seçin.");
        return;
    }

    const payload = {
        customerName: customerName,
        amount: amount,
        method: method
    };

    payBtn.disabled = true;
    payBtn.textContent = "İşleniyor...";

    try {
        const response = await fetch("/api/payments", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        });

        const data = await response.json();

        if (response.ok) {
            showSuccess(`
                <strong>Ödeme başarılı</strong><br>
                Yöntem: ${data.method}<br>
                Tutar: ${data.amount}<br>
                Mesaj: ${data.message}
            `);
        } else {
            showError(data.error || data.message || "Ödeme işlemi başarısız.");
        }
    } catch (error) {
        showError("Sunucuya ulaşılamadı.");
    } finally {
        payBtn.disabled = false;
        payBtn.textContent = "Ödeme Yap";
    }
}

function showSuccess(message) {
    resultDiv.className = "result success";
    resultDiv.innerHTML = message;
}

function showError(message) {
    resultDiv.className = "result error";
    resultDiv.innerHTML = `<strong>Hata:</strong> ${message}`;
}

function formatMethodName(method) {
    if (method === "creditCard") return "Kredi Kartı";
    if (method === "paypal") return "PayPal";
    if (method === "applePay") return "Apple Pay";
    return method;
}