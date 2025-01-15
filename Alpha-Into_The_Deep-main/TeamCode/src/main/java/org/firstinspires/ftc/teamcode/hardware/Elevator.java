package org.firstinspires.ftc.teamcode.hardware;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.hardware.Constraints.ElevetorConstraints;

@Disabled
public class Elevator extends SubsystemBase {
    /// definindo os motores do Elevador ///
    DcMotor rightMotor,leftMotor;
    ElevetorConstraints linear = new ElevetorConstraints();
    PIDController controller;
    int encoderPosition;
    double pidPower;

    /// criando o construtor do sistema de Elevator///
    public Elevator(DcMotor rightMotor, DcMotor leftMotor){
        this.rightMotor = rightMotor;
        this.leftMotor = leftMotor;

        this.rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /// variáveis para o PID
        controller = new PIDController(linear.kp,linear.ki,linear.kd);
        encoderPosition = Integer.parseInt(String.valueOf((rightMotor.getCurrentPosition() + leftMotor.getCurrentPosition())/2));
    }

    public void manualControl(float upButton, float downButton) {
        rightMotor.setPower(upButton - downButton * 0.7);
        leftMotor.setPower(upButton - downButton * 0.7);
    }

    public void pidManualControl(float upButton, float downButton){
        double position;
        int lastPosition = 0;
        rightMotor.setPower(upButton - downButton * 0.7);
        leftMotor.setPower(upButton - downButton * 0.7);
        encoderPosition = Integer.parseInt(String.valueOf((rightMotor.getCurrentPosition() + leftMotor.getCurrentPosition())/2));

        if (rightMotor.getPower() == 0 && leftMotor.getPower() == 0){
            pidTarget(lastPosition);
        }
        else{
            lastPosition = encoderPosition;
        }
    }
    public void highBasketHeight(boolean Button){
        /// TODO: fazer com que nessa parte um pid para a posição alta do Basket
        pidTarget(linear.HighBasketPosition);
    }
    public void lowBasketHeight(boolean Button){
        /// TODO: fazer com que nessa parte um pid para a posição baixa do Basket
    }
    public void highClipHeith(boolean Button){
        /// TODO: fazer com que nessa parte um pid para a posição alta do clip
    }
    public void lowClipHeith(boolean Button){
        /// TODO: fazer com que nessa parte um pid para a posição baixa do clip
    }

    public void pidTarget(int target){
        encoderPosition = Integer.parseInt(String.valueOf((rightMotor.getCurrentPosition() + leftMotor.getCurrentPosition())/2));
        pidPower = controller.calculate(encoderPosition,target);
        rightMotor.setPower(pidPower);
        leftMotor.setPower(pidPower);
    }

}
