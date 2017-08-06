package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.common.truth.Truth.assertThat
import org.hamcrest.CoreMatchers.any
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Modifier

@RunWith(MockitoJUnitRunner::class)
class RxTasksTest {

  private lateinit var constructor: Constructor<RxTasks>

  @Rule var expected = ExpectedException.none()

  @Mock internal lateinit var task: Task<Void>

  @Captor internal lateinit var captor: ArgumentCaptor<OnSuccessListener<Void>>

  @Before
  fun setUp() {
    constructor = RxTasks::class.java.getDeclaredConstructor()
  }

  @Test
  @Throws(Exception::class)
  fun shouldHavePrivateConstructor() {
    assertThat(Modifier.isPrivate(constructor.modifiers)).isTrue()
  }

  @Test
  @Throws(Exception::class)
  fun shouldThrowExceptionOnConstructor() {
    expected.expect(InvocationTargetException::class.java)
    expected.expectCause(any(IllegalStateException::class.java))

    constructor.isAccessible = true
    constructor.newInstance()
  }

  @Test
  @Throws(Exception::class)
  fun shouldCreateCompletableTask() {
    RxTasks.completable(task).subscribe()

    verify(task).addOnSuccessListener(captor.capture())
    assertThat(captor.value).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }

  @Test
  @Throws(Exception::class)
  fun shouldCreateSingleTask() {
    RxTasks.completable(task).subscribe()

    verify(task).addOnSuccessListener(captor.capture())
    assertThat(captor.value).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }
}
