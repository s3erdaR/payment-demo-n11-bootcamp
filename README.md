# Payment Integration Demo

Bu proje, mevcut bir ödeme sistemine yeni ödeme yöntemlerinin **SOLID prensiplerine uygun şekilde** nasıl entegre edileceğini göstermek amacıyla geliştirilmiştir.

## 🚀 Proje Amacı

- Mevcut ödeme sistemini bozmadan genişletmek  
- Yeni ödeme yöntemlerini kolayca ekleyebilmek  
- Temiz ve sürdürülebilir bir backend mimarisi oluşturmak  

## 🧰 Kullanılan Teknolojiler

- Java
- Spring Boot
- Maven
- HTML / CSS / JavaScript

## 💳 Desteklenen Ödeme Yöntemleri

- Credit Card  
- PayPal  
- Apple Pay  

## 🧠 Mimari Yaklaşım

Projede **Strategy Pattern** benzeri bir yapı kullanılmıştır.

Tüm ödeme yöntemleri ortak bir interface (`PaymentMethod`) üzerinden yönetilir.  
Her ödeme yöntemi kendi sınıfında implemente edilir.

Yeni bir ödeme yöntemi eklemek için:
- Yeni bir sınıf yazmak yeterlidir  
- Mevcut kodda değişiklik yapılmaz  

## 🔍 Reflection Kullanımı

Projede ödeme yöntemi eşleştirmesi sırasında **reflection** kullanılmıştır.

`PaymentMethodFactory` sınıfında:
- ödeme sınıflarının runtime'daki class bilgisi alınır  
- sınıf isimleri üzerinden dinamik olarak ödeme yöntemi belirlenir  

Bu sayede sistem:
- daha esnek hale gelir  
- yeni ödeme yöntemlerine kolayca uyum sağlar  

## 🧩 SOLID Prensipleri

### Single Responsibility Principle (SRP)
Her sınıf tek bir sorumluluğa sahiptir:
- Controller → request yönetir  
- Service → iş mantığını yönetir  
- Payment sınıfları → ödeme işlemini gerçekleştirir  

### Open/Closed Principle (OCP)
Sistem değişikliğe kapalı, geliştirmeye açıktır.  
Yeni ödeme yöntemi eklemek için mevcut kod değiştirilmez.

### Dependency Inversion Principle (DIP)
Üst seviye sınıflar somut sınıflara değil, abstraction’a bağımlıdır.

## 🖥️ UI (Kullanıcı Arayüzü)

Projede ödeme işlemini test edebilmek için basit bir kullanıcı arayüzü geliştirilmiştir.

Bu arayüz:

kullanıcıdan müşteri adı, tutar ve ödeme yöntemi alır
backend API ile iletişim kurar
sonucu ekranda gösterir.

👉 UI geliştirme sürecinde yapay zekâ (AI) araçlarından aktif olarak faydalanılmıştır.

<img width="2560" height="1218" alt="image" src="https://github.com/user-attachments/assets/78c2fb69-4d81-4866-bc52-eaa90575265d" />


## 📡 API Endpointleri

### Ödeme yöntemlerini listele
**GET** `/api/payments/methods`

### Ödeme Yap
**POST** `/api/payments`

```json
{
  "method": "paypal",
  "amount": 250.0,
  "customerName": "Ali"
}
