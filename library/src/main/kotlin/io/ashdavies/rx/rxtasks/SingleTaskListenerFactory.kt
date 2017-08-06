package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.SingleEmitter

internal class SingleTaskListenerFactory<Result> : TaskListenerFactory<Result, SingleEmitter<Result>> {

  override fun createOnSuccessListener(emitter: SingleEmitter<Result>): OnSuccessListener<Result> {
    return SingleEmitterSuccessListener(emitter)
  }

  override fun createOnFailureListener(emitter: SingleEmitter<Result>): OnFailureListener {
    return SingleEmitterFailureListener(emitter)
  }
}
