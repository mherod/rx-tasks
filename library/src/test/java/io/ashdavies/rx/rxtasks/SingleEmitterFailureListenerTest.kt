package io.ashdavies.rx.rxtasks

import io.reactivex.SingleEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleEmitterFailureListenerTest {

  private lateinit var listener: SingleEmitterFailureListener<String>

  @Mock internal lateinit var emitter: SingleEmitter<String>
  @Mock internal lateinit var exception: Exception

  @Before
  fun setUp() {
    listener = SingleEmitterFailureListener(emitter)
  }

  @Test
  fun shouldCallOnErrorWithException() {
    listener.onFailure(exception)

    verify(emitter, never()).onSuccess(anyString())
    verify(emitter).onError(exception)
  }
}
