package io.ashdavies.rx.rxtasks

import io.reactivex.SingleEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.any
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleEmitterSuccessListenerTest {

  private lateinit var listener: SingleEmitterSuccessListener<String>

  @Mock internal lateinit var emitter: SingleEmitter<String>

  @Before
  fun setUp() {
    listener = SingleEmitterSuccessListener(emitter)
  }

  @Test
  fun shouldCallOnSuccess() {
    listener.onSuccess(RESULT)

    verify<SingleEmitter<String>>(emitter).onSuccess(RESULT)
    verify<SingleEmitter<String>>(emitter, never()).onError(any(Throwable::class.java))
  }

  companion object {

    private val RESULT = "SUCCESS"
  }
}
