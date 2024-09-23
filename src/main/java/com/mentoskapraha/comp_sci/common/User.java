package com.mentoskapraha.comp_sci.common;

/**
 * This class represents a basic user with
 * several methods for logging in, account
 * recovery, etc.
 * @author MentoskaPraha
 */
public class User {
  /**
   * The username of the user.
   */
  public final String username;

  /**
   * The user's password.
   */
  private String password;

  /**
   * Whether recovery is enabled on the users account.
   */
  public boolean recovery = false;

  /**
   * The user's recovery code.
   */
  private int recoveryCode = 0;

  /**
   * Creates a new user
   * @param username The username of the new user.
   * @param password The password of the new user.
   * @author MentoskaPraha
   */
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * Checks if the user's password is valid.
   * @param password The user's password.
   * @return True if the password is valid, false if it's invalid.
   * @author MentoskaPraha
   */
  public boolean login(String password) {
    return password.matches(this.password);
  }

  /**
   * Enables password recovery via recovery code.
   * @return The recovery code to use
   * @author MentoskaPraha
   */
  public int enableRecovery() {
    this.recovery = true;
    this.recoveryCode = Utils.getRandomNumber(10000000, 99999999);
    return this.recoveryCode;
  }

  /**
   * Get the recovery code of the user, requires their password.
   * @param password The user's password.
   * @return The recovery code, if 0 is returned recovery is
   * disabled, if 1 is returned the password is invalid.
   * @author MentoskaPraha
   */
  public int getRecoveryCode(String password) {
    if(!this.recovery) return 0;
    if(password.matches(this.password)){
      return this.recoveryCode;
    } else {
      return 0;
    }
  }

  /**
   * Resets the user's password, the recovery code will also be changed.
   * @param recoveryCode The user's recovery code.
   * @param newPassword The new password, must not match the old password.
   * @return The recovery code if it was successful, 0 if recovery is disabled
   * on the account,1 if the code is invalid, 2 if the new password matches the old one.
   * @author MentoskaPraha
   */
  public int resetPassword(int recoveryCode, String newPassword) {
    if(!this.recovery) return 0;
    if(recoveryCode != this.recoveryCode) return 1;
    if(newPassword.matches(this.password)) return 2;

    this.password = newPassword;
    this.recoveryCode = Utils.getRandomNumber(10000000, 99999999);
    return this.recoveryCode;
  }
}
