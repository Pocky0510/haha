package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.LimelightConstants;



public class Limelight extends SubsystemBase {

    NetworkTable table = NetworkTableInstance.getDefault().getTable(LimelightConstants.Name);
    
    public boolean Tag_Detected = false;
    public double ID;
    public double ta;
    public double tx;


public double getFiducialID(){
    ID = LimelightHelpers.getFiducialID("");
    return ID;
}

public double getTag_Area(){
    ID = LimelightHelpers.getTA("");
    return ID;
}

public double getTX(){
    ID = LimelightHelpers.getTX("");
    return ID;
}

}