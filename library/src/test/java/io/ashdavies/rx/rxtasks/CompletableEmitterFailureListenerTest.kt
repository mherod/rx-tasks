package io.ashdavies.rx.rxtasks

import io.reactivex.CompletableEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompletableEmitterFailureListenerTest {

  private lateinit var listener: CompletableEmitterFailureListener

  @Mock internal lateinit var emitter: CompletableEmitter
  @Mock internal lateinit var exception: Exception

  @Before
  fun setUp() {
    listener = CompletableEmitterFailureListener(emitter)
  }

  @Test
  fun shouldCallOnErrorWithException() {
    listener.onFailure(exception)

    verify<CompletableEmitter>(emitter, never()).onComplete()
    verify<CompletableEmitter>(emitter).onError(exception)
  }
}
