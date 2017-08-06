package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.CompletableEmitter

internal class CompletableTaskListenerFactory : TaskListenerFactory<Void, CompletableEmitter> {

  override fun createOnSuccessListener(emitter: CompletableEmitter): OnSuccessListener<Void> {
    return CompletableEmitterSuccessListener(emitter)
  }

  override fun createOnFailureListener(emitter: CompletableEmitter): OnFailureListener {
    return CompletableEmitterFailureListener(emitter)
  }
}
