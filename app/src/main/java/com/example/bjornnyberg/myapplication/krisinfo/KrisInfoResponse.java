package com.example.bjornnyberg.myapplication.krisinfo;

import java.util.List;

/**
 * Created by bjornnyberg on 17/03/16.
 */
public interface KrisInfoResponse {
    void processFinish(List<CapMessage> messageList);
}
