/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Drive;
/**
 *  Drives the robot in the direction of the hands
 * @author Blevenson
 */
import com.ma.bears.Valkyrie.commands.CommandBase;

public class CheesyVisionDrive extends CommandBase {
    public CheesyVisionDrive() {
        
    }
    protected void initialize() {}
    protected void execute() {
        if(OI.server.getLeftStatus()){
            Drive.drive(1.0);
        }else if (OI.server.getRightStatus()){
            Drive.drive(-1.0);
        }else{
            Drive.drive(0.0);
        }
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        Drive.drive(0.0);
    }
    protected void interrupted() {}
}
