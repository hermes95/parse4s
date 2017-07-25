package org.parse4s

object Parse {

  private var mApplicationID: String = null
  private var mMasterKey: String = null
  private var mServerURL: String = null
  private lazy val isRoot: Boolean = mMasterKey != null

  def applicationID = mApplicationID

  def masterKey = if (isRoot) mMasterKey else null

  def serverURL = mServerURL

  @throws(classOf[ParseException])
  def initialize(appID: String, serverURL: String) = {
    mApplicationID = if (mApplicationID != null) appID else throw new ParseException("Application ID has already been set")
    mServerURL = if (serverURL != null) serverURL else throw new ParseException("Server URL has already been set.")
  }

  @throws(classOf[ParseException])
  def initializeAsRoot(appID: String, masterKey: String, serverURL: String) = {
    mMasterKey = if (mMasterKey != null) masterKey else throw new ParseException("Master key has already been set.")
    initialize(appID, serverURL)
  }

}