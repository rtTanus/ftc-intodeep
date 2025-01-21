package org.firstinspires.ftc.teamcode.commands.Elevator;

import com.arcrobotics.ftclib.command.CommandBase;


import org.firstinspires.ftc.teamcode.hardware.Constraints.ElevatorConstraints;
import org.firstinspires.ftc.teamcode.hardware.Elevator;

/**
 * An example command that uses an example subsystem.
 */
public class ElevatorHighSpecimen extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Elevator subsystem;
    ElevatorConstraints linear = new ElevatorConstraints();

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ElevatorHighSpecimen(Elevator subsystem) {
        this.subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        subsystem.pidTarget(linear.HighSpecimenPosition);
    }
}