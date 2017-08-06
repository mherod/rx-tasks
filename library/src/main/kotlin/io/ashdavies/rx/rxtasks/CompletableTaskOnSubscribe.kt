package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter
import io.reactivex.CompletableOnSubscribe

internal class CompletableTaskOnSubscribe : TaskOnSubscribe<Void, CompletableEmitter>, CompletableOnSubscribe {

  @JvmOverloads
  constructor(task: Task<Void>, factory: TaskListenerFactory<Void, CompletableEmitter> = CompletableTaskListenerFactory()) : super(task, factory)
}
