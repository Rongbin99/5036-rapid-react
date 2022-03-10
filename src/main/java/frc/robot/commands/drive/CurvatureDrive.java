package frc.robot.commands.drive;

import java.util.Set;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drivetrain;

public class CurvatureDrive implements Command {
    private Drivetrain drivetrain;
    private DoubleSupplier throttle, wheel;

    public CurvatureDrive(Drivetrain drivetrain, DoubleSupplier throttle, DoubleSupplier wheel) {
        this.drivetrain = drivetrain;
        this.throttle = throttle;
        this.wheel = wheel;
    }

    @Override
    public void execute() {
        drivetrain.curvatureDrive(
            throttle.getAsDouble(),
            wheel.getAsDouble()
        );
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(drivetrain);
    }
}
