package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
import io.reactivex.SingleEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleTaskListenerFactoryTest {

  private lateinit var factory: TaskListenerFactory<Void, SingleEmitter<Void>>

  @Mock internal lateinit var emitter: SingleEmitter<Void>

  @Before
  fun setUp() {
    factory = SingleTaskListenerFactory<Void>()
  }

  @Test
  fun shouldReturnCompletableEmitterSuccessListener() {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(SingleEmitterSuccessListener::class.java)
  }

  @Test
  fun shouldReturnCompletableEmitterFailureListener() {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(SingleEmitterFailureListener::class.java)
  }
}
