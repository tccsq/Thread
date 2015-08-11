package com.pera.test.thread06;

import java.util.concurrent.Phaser;

/**
 * Created by csq on 2015/8/11.
 */
public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
            }

    private boolean finishExam() {
        System.out.println("Phaser: All the students hava finished the exam\n");
        System.out.println("Phaser: Thrank you for your time \n");
        return false;
    }

    private boolean finishSecondExercise() {
        System.out.println("Phaser: All the students hava finished the 2nd exercise\n");
        System.out.println("Phaser: Let us start the 3rd one \n");
        return false;
    }

    private boolean finishFirstExercise() {
        System.out.println("Phaser: All the students hava finished the 1st exercise\n");
        System.out.println("Phaser: Let us start the 2nd one \n");
        return false;
    }

    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready\n");
        System.out.printf("Phaser: We hava %d students\n",getRegisteredParties());
        return false;
    }
}
