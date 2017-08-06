package io.ashdavies.rx.rxtasks

import io.reactivex.CompletableEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.any
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompletableEmitterSuccessListenerTest {

  private lateinit var listener: CompletableEmitterSuccessListener

  @Mock internal lateinit var emitter: CompletableEmitter

  @Before
  fun setUp() {
    listener = CompletableEmitterSuccessListener(emitter)
  }

  @Test
  fun shouldCallOnComplete() {
    listener.onSuccess(null)

    verify(emitter).onComplete()
    verify(emitter, never()).onError(any(Throwable::class.java))
  }
}
