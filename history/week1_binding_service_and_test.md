# Binding Service

Service 쓸때 주의할점. background != (not main thread)

## Local Binding

- Service 와 호출자(Activity) 가 같은 어플리케이션일 경우.
- Binder를 통해서 service instance를 불러와 public method를 호출해서 사용.
- blocking 이기 때문에 별도로 thread관리를 해줘야 함.

## Messenger

- Service와 호출자(Activity) 가 다른 어플리케이션일 경우.
- Messenger를 통해 Worker Thread에서 동작하는 작업큐를 만들어 한번에 하나의 동작을 비동기적으로 실행.

## AIDL

- Service와 호출자(Activity) 가 다른 어플리케이션일 경우.
- AIDL을 통해 생성되는 class 파일을 통해 통신
- blocking이기 때문에 별도로 thread관리를 해줘야 함.
- AIDL의 경우 서버 어플리케이션의 AIDL패키지를 복사해서 client로 배포해야 함.

---

# Android Testing

## 테스트 코드를 작성하면 좋은점.

테스트 하려는 코드까지의 진입이 오래걸릴 경우. 테스트코드를 통해 검증할 코드까지 빠르게 진입이 가능.

테스트 코드 빌드는 시간이 적게 걸림.

테스트 시간이 적게 걸림

UnitTest

Instrumented Test