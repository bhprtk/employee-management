package org.example.project4.dao;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Represents an attendance record for an employee.
 * This class contains information about clock-in and clock-out times,
 * the associated employee, and the date of the attendance.
 */
public class Attendance {

    /**
     * The unique identifier for the attendance record.
     */
    private int id;

    /**
     * The ID of the employee associated with this attendance record.
     */
    private int employeeId;

    /**
     * The timestamp for when the employee clocked in.
     */
    private Timestamp timeIn;

    /**
     * The timestamp for when the employee clocked out.
     */
    private Timestamp timeOut;

    /**
     * The date of the attendance record.
     */
    private Date date;

    // Getters and Setters

    /**
     * Gets the unique identifier of the attendance record.
     *
     * @return the ID of the attendance record.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the attendance record.
     *
     * @param id the ID to set for the attendance record.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the employee ID associated with this attendance record.
     *
     * @return the employee ID.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee ID associated with this attendance record.
     *
     * @param employeeId the employee ID to set.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the timestamp for when the employee clocked in.
     *
     * @return the clock-in timestamp.
     */
    public Timestamp getTimeIn() {
        return timeIn;
    }

    /**
     * Sets the timestamp for when the employee clocked in.
     *
     * @param timeIn the clock-in timestamp to set.
     */
    public void setTimeIn(Timestamp timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * Gets the timestamp for when the employee clocked out.
     *
     * @return the clock-out timestamp.
     */
    public Timestamp getTimeOut() {
        return timeOut;
    }

    /**
     * Sets the timestamp for when the employee clocked out.
     *
     * @param timeOut the clock-out timestamp to set.
     */
    public void setTimeOut(Timestamp timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Gets the date of the attendance record.
     *
     * @return the date of the attendance record.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the attendance record.
     *
     * @param date the date to set for the attendance record.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
