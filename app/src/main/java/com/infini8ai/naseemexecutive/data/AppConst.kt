package com.infini8ai.naseemexecutive.data

import java.text.SimpleDateFormat


const val DELAY_HOME = 1000L
const val DELAY_LOGIN = 2000L


/*User Event*/
const val ON_CLICK_SIGN_UP = 1
const val ON_CLICK_LOGIN_IN = 2
const val ON_CLICK_CREATE_ORGANIZATION = 4
const val ON_CLICK_FEE_BTN = 5
const val ON_INVENTORY_CLICKED = 6
const val ON_JAN_CLICKED = 7

// switch button cases//
const val USER_EXISTS = 0
const val USER_NOT_EXISTS= 1
const val LOGIN_FAILED = 3

const val SUCCSESS = 0
const val FAIlURE = 1

/*API call methods name*/
const val GET_ORGANIZATION_FOR_LOGIN= "getOrganization"
const val GET_SCHOOL_BY_ORGANIZATION = "getSchoolsByOrganization"


/*KEYS for Shared Preferences*/

const val ORGANIZATION_ID = "organization_id"



/*User Event*/
const val KEY_USER_LOGIN = "is_user_logged_in"

/*Put Exta Constants*/
const val ORGANIZATION_OBJECT = "organizationObject"
const val SCHOOL_OBJECT = "schoolObject"




/*Date and Time Format Constants */
var attendanceDateFormater = SimpleDateFormat("dd-MM-yyyy")
var monthAndYearFormater = SimpleDateFormat("MM-yyyy")


var monthFormater = SimpleDateFormat("MM")
var yearFormater = SimpleDateFormat("yyyy")
var monthFormat = SimpleDateFormat("MMMM")
var dateFormatter = SimpleDateFormat("dd-MM-yyyy")
var dateFormatter2 = SimpleDateFormat("yyyy-MM-dd")
var dateAndTimeFormater = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")

//https://stackoverflow.com/questions/16084474/convert-time-value-to-format-hhmm-am-pm-using-android
var timeFormat1 = SimpleDateFormat("hh:mm:ss")
var timeFormat2 = SimpleDateFormat("hh:mm a")
