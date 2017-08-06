package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter
import io.reactivex.CompletableOnSubscribe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompletableTaskOnSubscribeTest {

  private lateinit var onSubscribe: CompletableOnSubscribe

  @Mock internal lateinit var task: Task<Void>
  @Mock internal lateinit var emitter: CompletableEmitter

  @Mock internal lateinit var factory: TaskListenerFactory<Void, CompletableEmitter>
  @Mock internal lateinit var onSuccessListener: OnSuccessListener<Void>
  @Mock internal lateinit var onFailureListener: OnFailureListener

  @Before
  fun setUp() {
    onSubscribe = CompletableTaskOnSubscribe(task, factory)
  }

  @Test
  fun shouldSubscribeWithOnSuccessListener() {
    `when`(factory.createOnSuccessListener(emitter)).thenReturn(onSuccessListener)

    onSubscribe.subscribe(emitter)

    verify<TaskListenerFactory<Void, CompletableEmitter>>(factory).createOnSuccessListener(emitter)
    verify<Task<Void>>(task).addOnSuccessListener(onSuccessListener)
  }

  @Test
  fun shouldSubscribeWithOnFailureListener() {
    `when`(factory.createOnFailureListener(emitter)).thenReturn(onFailureListener)

    onSubscribe.subscribe(emitter)

    verify<TaskListenerFactory<Void, CompletableEmitter>>(factory).createOnFailureListener(emitter)
    verify<Task<Void>>(task).addOnFailureListener(onFailureListener)
  }
}
