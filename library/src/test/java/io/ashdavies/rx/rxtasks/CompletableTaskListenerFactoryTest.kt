package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
import io.reactivex.CompletableEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompletableTaskListenerFactoryTest {

  private lateinit var factory: TaskListenerFactory<Void, CompletableEmitter>

  @Mock internal lateinit var emitter: CompletableEmitter

  @Before
  fun setUp() {
    factory = CompletableTaskListenerFactory()
  }

  @Test
  fun shouldReturnCompletableEmitterSuccessListener() {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }

  @Test
  fun shouldReturnCompletableEmitterFailureListener() {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(CompletableEmitterFailureListener::class.java)
  }
}
