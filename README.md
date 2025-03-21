# 📌 Android Asynchronous Programming Example

## 🚀 프로젝트 소개
이 프로젝트는 **안드로이드에서 비동기 프로그래밍을 수행하는 다양한 방법**을 비교하고 학습하기 위한 예제입니다.

안드로이드에서는 네트워크 요청이나 백그라운드 작업을 수행할 때 UI가 멈추는 것을 방지하기 위해 비동기 처리가 필수적입니다. 이를 위해 다양한 기법이 존재하며, 본 프로젝트에서는 다음과 같은 방법을 사용하여 구현하였습니다.

## 🔹 사용된 비동기 기법
1. **Coroutine**
    - Kotlin의 `Coroutine`을 활용한 비동기 처리 방식
    - `Dispatchers.IO`에서 백그라운드 작업 수행 후 `withContext(Dispatchers.Main)`을 통해 UI 업데이트

2. **Flow**
    - `Flow`를 활용하여 데이터 스트림을 비동기적으로 처리
    - `emit()`을 사용하여 데이터를 방출하고 `collect()`를 통해 UI 업데이트

3. **RxJava**
    - `Single.fromCallable {}`을 사용하여 비동기 작업 실행
    - `subscribeOn(Schedulers.io())`에서 실행하고 `observeOn(AndroidSchedulers.mainThread())`에서 UI 업데이트

4. **WorkManager**
    - `WorkManager`를 사용하여 백그라운드에서 안정적으로 작업 수행
    - `OneTimeWorkRequestBuilder<MyWorker>()`를 활용하여 작업 요청 및 실행

## ⚡ 주요 기능
| 기능 | 설명 |
|------|------|
| **Coroutine 처리** | 코루틴을 활용한 네트워크 요청 시뮬레이션 |
| **Flow 데이터 스트림** | Flow를 활용하여 데이터를 순차적으로 방출하고 UI 업데이트 |
| **RxJava 비동기 처리** | RxJava의 `Single`을 활용하여 네트워크 요청 실행 |
| **WorkManager 작업** | WorkManager를 사용하여 백그라운드에서 작업 실행 |


## ✅ 각 방식의 장단점
| 방식 | 장점 | 단점 |
|------|------|------|
| **Coroutine** | 코드가 간결하고 가독성이 좋음 | 복잡한 연산 처리에는 한계 |
| **Flow** | 데이터 스트림을 순차적으로 처리 가능 | 흐름을 잘못 관리하면 데이터 손실 가능 |
| **RxJava** | 강력한 연산자 제공 (`map`, `flatMap` 등) | 학습 곡선이 높음 |
| **WorkManager** | 앱 종료 후에도 백그라운드 작업 유지 가능 | 즉각적인 실행이 필요한 경우 부적합 |

## 📌 참고 자료
- [Kotlin Coroutine 공식 문서](https://developer.android.com/kotlin/coroutines)
- [Kotlin Flow 공식 문서](https://developer.android.com/kotlin/flow)
- [RxJava 공식 문서](https://github.com/ReactiveX/RxJava)
- [WorkManager 공식 문서](https://developer.android.com/topic/libraries/architecture/workmanager)

