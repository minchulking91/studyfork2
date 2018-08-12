# Koin - DI(Dependency injection)

구성요소간 의존관계를 소스코드 내부가 아닌 외부에서 설정하는 것.

- UnitTest 가 쉬워짐.
- 코드 수정시 영향받는 부분이 적어짐.

Koin을 통해 생성자 주입을 쉽게 할 수 있음.

https://insert-koin.io/

# Gradle dependency tree

koin과 androidX는 같이 쓸수 없습니다.

koin에서 support library를 쓰기 때문!

Program type already present - 에러가 날 경우 gradle을 통해 어떤 라이브러리에서 dependency가 충돌되는지 알 수 있음.

gradlew :app:dependencies [--configuration <configuration>]

`gradlew :app:dependencies --configuration debugCompileClasspath`

```debugCompileClasspath - Resolved configuration for compilation for variant: debug
+--- org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.2.51
|    --- org.jetbrains.kotlin:kotlin-stdlib:1.2.51
|         +--- org.jetbrains.kotlin:kotlin-stdlib-common:1.2.51
|         --- org.jetbrains:annotations:13.0
+--- com.android.support:appcompat-v7:28.0.0-rc01
|    +--- com.android.support:support-annotations:28.0.0-rc01
|    +--- com.android.support:support-compat:28.0.0-rc01
|    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    +--- com.android.support:collections:28.0.0-rc01
|    |    |    --- com.android.support:support-annotations:28.0.0-rc01
|    |    +--- android.arch.lifecycle:runtime:1.1.1
|    |    |    +--- android.arch.lifecycle:common:1.1.1
|    |    |    |    --- com.android.support:support-annotations:26.1.0 -> 28.0.0-rc01
|    |    |    +--- android.arch.core:common:1.1.1
|    |    |    |    --- com.android.support:support-annotations:26.1.0 -> 28.0.0-rc01
|    |    |    --- com.android.support:support-annotations:26.1.0 -> 28.0.0-rc01
|    |    --- com.android.support:versionedparcelable:28.0.0-rc01
|    |         +--- com.android.support:support-annotations:28.0.0-rc01
|    |         --- com.android.support:collections:28.0.0-rc01 (*)
|    +--- com.android.support:collections:28.0.0-rc01 (*)
|    +--- com.android.support:cursoradapter:28.0.0-rc01
|    |    --- com.android.support:support-annotations:28.0.0-rc01
|    +--- com.android.support:support-core-utils:28.0.0-rc01
|    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    +--- com.android.support:documentfile:28.0.0-rc01
|    |    |    --- com.android.support:support-annotations:28.0.0-rc01
|    |    +--- com.android.support:loader:28.0.0-rc01
|    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    +--- android.arch.lifecycle:livedata-core:1.1.1
|    |    |    |    +--- android.arch.lifecycle:common:1.1.1 (*)
|    |    |    |    +--- android.arch.core:common:1.1.1 (*)
|    |    |    |    --- android.arch.core:runtime:1.1.1
|    |    |    |         +--- com.android.support:support-annotations:26.1.0 -> 28.0.0-rc01
|    |    |    |         --- android.arch.core:common:1.1.1 (*)
|    |    |    --- android.arch.lifecycle:viewmodel:1.1.1
|    |    |         --- com.android.support:support-annotations:26.1.0 -> 28.0.0-rc01
|    |    +--- com.android.support:localbroadcastmanager:28.0.0-rc01
|    |    |    --- com.android.support:support-annotations:28.0.0-rc01
|    |    --- com.android.support:print:28.0.0-rc01
|    |         --- com.android.support:support-annotations:28.0.0-rc01
|    +--- com.android.support:support-fragment:28.0.0-rc01
|    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    +--- com.android.support:support-core-ui:28.0.0-rc01
|    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:support-core-utils:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:customview:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    --- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:viewpager:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    |    --- com.android.support:customview:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:coordinatorlayout:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    |    --- com.android.support:customview:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:drawerlayout:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    |    --- com.android.support:customview:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:slidingpanelayout:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    |    --- com.android.support:customview:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:interpolator:28.0.0-rc01
|    |    |    |    --- com.android.support:support-annotations:28.0.0-rc01
|    |    |    +--- com.android.support:swiperefreshlayout:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    |    --- com.android.support:interpolator:28.0.0-rc01 (*)
|    |    |    +--- com.android.support:asynclayoutinflater:28.0.0-rc01
|    |    |    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    |    |    --- com.android.support:support-compat:28.0.0-rc01 (*)
|    |    |    --- com.android.support:cursoradapter:28.0.0-rc01 (*)
|    |    +--- com.android.support:support-core-utils:28.0.0-rc01 (*)
|    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    +--- com.android.support:loader:28.0.0-rc01 (*)
|    |    --- android.arch.lifecycle:viewmodel:1.1.1 (*)
|    +--- com.android.support:support-vector-drawable:28.0.0-rc01
|    |    +--- com.android.support:support-annotations:28.0.0-rc01
|    |    --- com.android.support:support-compat:28.0.0-rc01 (*)
|    --- com.android.support:animated-vector-drawable:28.0.0-rc01
|         +--- com.android.support:support-vector-drawable:28.0.0-rc01 (*)
|         --- com.android.support:support-core-ui:28.0.0-rc01 (*)
+--- com.android.support.constraint:constraint-layout:1.1.2
|    --- com.android.support.constraint:constraint-layout-solver:1.1.2
+--- org.koin:koin-android:0.9.3
|    --- org.koin:koin-core:0.9.3
|         --- org.jetbrains.kotlin:kotlin-stdlib:1.2.41 -> 1.2.51 (*)
+--- org.koin:koin-android-architecture:0.9.3
|    +--- org.koin:koin-android:0.9.3 (*)
|    --- android.arch.lifecycle:extensions:1.1.1
|         +--- android.arch.lifecycle:runtime:1.1.1 (*)
|         +--- android.arch.core:common:1.1.1 (*)
|         +--- android.arch.core:runtime:1.1.1 (*)
|         +--- com.android.support:support-fragment:26.1.0 -> 28.0.0-rc01 (*)
|         +--- android.arch.lifecycle:common:1.1.1 (*)
|         +--- android.arch.lifecycle:livedata:1.1.1
|         |    +--- android.arch.core:runtime:1.1.1 (*)
|         |    +--- android.arch.lifecycle:livedata-core:1.1.1 (*)
|         |    --- android.arch.core:common:1.1.1 (*)
|         --- android.arch.lifecycle:viewmodel:1.1.1 (*)
--- android.arch.lifecycle:extensions:1.1.1 (*)
```

