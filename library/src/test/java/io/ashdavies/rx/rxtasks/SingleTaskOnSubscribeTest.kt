package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleTaskOnSubscribeTest {

  private lateinit var onSubscribe: SingleOnSubscribe<String>

  @Mock internal lateinit var task: Task<String>
  @Mock internal lateinit var emitter: SingleEmitter<String>

  @Mock internal lateinit var factory: TaskListenerFactory<String, SingleEmitter<String>>
  @Mock internal lateinit var onSuccessListener: OnSuccessListener<String>
  @Mock internal lateinit var onFailureListener: OnFailureListener

  @Before
  fun setUp() {
    onSubscribe = SingleTaskOnSubscribe(task, factory)
  }

  @Test
  fun shouldSubscribeWithOnSuccessListener() {
    `when`(factory.createOnSuccessListener(emitter)).thenReturn(onSuccessListener)

    onSubscribe.subscribe(emitter)

    verify<TaskListenerFactory<String, SingleEmitter<String>>>(factory).createOnSuccessListener(emitter)
    verify<Task<String>>(task).addOnSuccessListener(onSuccessListener)
  }

  @Test
  fun shouldSubscribeWithOnFailureListener() {
    `when`(factory.createOnFailureListener(emitter)).thenReturn(onFailureListener)

    onSubscribe.subscribe(emitter)

    verify<TaskListenerFactory<String, SingleEmitter<String>>>(factory).createOnFailureListener(emitter)
    verify<Task<String>>(task).addOnFailureListener(onFailureListener)
  }
}
