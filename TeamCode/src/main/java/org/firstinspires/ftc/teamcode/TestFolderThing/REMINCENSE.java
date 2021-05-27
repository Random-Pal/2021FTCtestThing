package org.firstinspires.ftc.teamcode.TestFolderThing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class REMINCENSE extends LinearOpMode {
    private DcMotor backLeft;
    private DcMotor backRight;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        backLeft = hardwareMap.get(DcMotor.class,"backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        waitForStart();
        while (opModeIsActive()) {
            double backLeftPower;
            double backRightPower;
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;

            backLeftPower = Range.clip(drive + turn, -1, +1);
            backRightPower = Range.clip(drive - turn, -1, 1);

            backLeft.setPower(backLeftPower);
            backRight.setPower(backRightPower);
        }

    }
}
