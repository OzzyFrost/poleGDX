package com.mygdx.game;

public class Task {
    public static String[][] question = {
            {"форма образования и расходования денежных средств, предназначенных для финансового " +
                    "обеспечения задач и функций государства и местного самоуправления", "Бюджет"}
    };

    public static String getQuestion(int i){
        return question[i][0].toUpperCase();
    }
    public static String getAnswer(int i){
        return question[i][1].toUpperCase();
    }
}
