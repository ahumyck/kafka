package com.kafka.custom_logic.task;

import java.util.List;

public interface TaskGenerator {

    IndexedTask produceTask();

    List<IndexedTask> producesTasks(int howMany);
}
