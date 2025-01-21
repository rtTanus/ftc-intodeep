package org.firstinspires.ftc.teamcode.commands.Claw;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.hardware.Elevator;

public class ClawOpen extends CommandBase {
    public ClawOpen(Elevator subsystem) {

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    @Override
    public void execute(){

    }
}
