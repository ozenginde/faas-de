package com.faas.core.utils.config;

public class AppConstant {

    public static final String API_VERSION = "/v1";

    public static final int GENERAL_SUCCESS_CODE = 200;
    public static final int GENERAL_FAIL_CODE = 201;
    public static final String GENERAL_SUCCESS_STATUS = "SUCCESS";
    public static final String GENERAL_FAIL_STATUS = "FAIL";


    public static final String STATE_NOK = "NOK";
    public static final String STATE_OK = "OK";


    public static final String MANAGER_USER = "MANAGER_USER";
    public static final String BASIC_MANAGER = "BASIC_MANAGER";
    public static final String SUPER_MANAGER = "SUPER_MANAGER";

    public static final String AGENT_USER = "AGENT_USER";
    public static final String BASIC_AGENT = "BASIC_AGENT";
    public static final String AUTO_AGENT = "AUTO_AGENT";


    public static final String ACTIVE_STATUS = "ACTIVE_STATUS";
    public static final String PASSIVE_STATUS = "PASSIVE_STATUS";

    public static final String PROCESS_DATA_TYPE = "PROCESS";


    public static final String SOURCE_URL = "SOURCE_URL";
    public static final String PWA_URL = "PWA_URL";


    public static final String ACTIVE_CAMPAIGN = "ACTIVE_CAMPAIGN";
    public static final String PASSIVE_CAMPAIGN = "PASSIVE_CAMPAIGN";

    public static final String ALL_CAMPAIGNS = "ALL_CAMPAIGNS";

    public static final String OUTBOUND_CAMPAIGN = "OUTBOUND";
    public static final String INBOUND_CAMPAIGN = "INBOUND";

    public static final String MANUAL_CAMPAIGN = "MANUAL";
    public static final String INQUIRY_CAMPAIGN = "INQUIRY";
    public static final String AUTOMATIC_CAMPAIGN = "AUTOMATIC";


    public static final String ACTIVE_PROCESS = "ACTIVE_PROCESS";
    public static final String PASSIVE_PROCESS = "PASSIVE_PROCESS";
    public static final String FINISHED_PROCESS = "FINISHED_PROCESS";
    public static final String ALL_PROCESSES = "ALL_PROCESSES";

    public static final String READY_SCENARIO = "READY_SCENARIO";
    public static final String ACTIVE_SCENARIO = "ACTIVE_SCENARIO";
    public static final String FINISHED_SCENARIO = "FINISHED_SCENARIO";
    public static final String ALL_SCENARIOS = "ALL_SCENARIOS";


    public static final String READY_CLIENT = "READY_CLIENT";
    public static final String BUSY_CLIENT = "BUSY_CLIENT";
    public static final String ALL_CLIENTS = "ALL_CLIENTS";


    public static final String READY_INQUIRY = "READY_INQUIRY";
    public static final String ACTIVE_INQUIRY = "ACTIVE_INQUIRY";
    public static final String COMPLETED_INQUIRY = "COMPLETED_INQUIRY";
    public static final String ALL_INQUIRIES = "ALL_INQUIRIES";


    public static final String READY_SESSION = "READY_SESSION";
    public static final String ACTIVE_SESSION = "ACTIVE_SESSION";
    public static final String COMPLETED_SESSION = "COMPLETED_SESSION";
    public static final String ALL_SESSIONS = "ALL_SESSIONS";


    public static final String OPERATION_READY = "OPERATION_READY";
    public static final String OPERATION_ACTIVE = "OPERATION_ACTIVE";
    public static final String OPERATION_COMPLETED = "OPERATION_COMPLETED";


    public static final String RESULT_NONE = "RESULT_NONE";
    public static final String RESULT_SUCCESS = "RESULT_SUCCESS";
    public static final String RESULT_REJECTED = "RESULT_REJECTED";
    public static final String RESULT_NO_RESPONSE = "RESULT_NO_RESPONSE";
    public static final String RESULT_FALSE_DATA = "RESULT_FALSE_DATA";


    public static final String ACTION_READY = "ACTION_NEW";
    public static final String ACTION_IN_PROGRESS = "ACTION_IN_PROGRESS";
    public static final String ACTION_SUCCESSFUL = "ACTION_SUCCESSFUL";
    public static final String ACTION_FAILED = "ACTION_FAILED";


    public static final String FLASH_SMS = "FLASH_SMS";
    public static final String STANDARD_SMS = "STANDARD_SMS";

    public static final String TEXT_WAPP = "TEXT_WAPP";
    public static final String IMAGE_WAPP = "IMAGE_WAPP";
    public static final String VIDEO_WAPP = "VIDEO_WAPP";
    public static final String VOICE_WAPP = "VOICE_WAPP";

    public static final String STANDARD_EMAIL = "STANDARD_EMAIL";

    public static final String TEXT_PUSH = "TEXT_PUSH";


    public static final String READY_MESSAGE = "READY_MESSAGE";
    public static final String SENT_MESSAGE = "SENT_MESSAGE";
    public static final String FAILED_MESSAGE = "FAILED_MESSAGE";


    public static final String ACTIVE_CALL = "ACTIVE_CALL";
    public static final String FAILED_CALL = "FAILED_CALL";
    public static final String FINISHED_CALL = "FINISHED_CALL";


    public static final String READY_SESSIONS_SUMMARY = "READY_SESSIONS_SUMMARY";
    public static final String ACTIVE_SESSIONS_SUMMARY = "ACTIVE_SESSIONS_SUMMARY";
    public static final String COMPLETED_SESSIONS_SUMMARY = "COMPLETED_SESSIONS_SUMMARY";
    public static final String TOTAL_SESSIONS_SUMMARY = "TOTAL_SESSIONS_SUMMARY";


    public static final String TOTAL_CAMPAIGNS_SUMMARY = "TOTAL_CAMPAIGNS_SUMMARY";

    public static final String READY_INQUIRY_SUMMARY = "READY_INQUIRY_SUMMARY";
    public static final String ACTIVE_INQUIRY_SUMMARY = "ACTIVE_INQUIRY_SUMMARY";





    public static final String USER_TYPE= "USER_TYPE";
    public static final String CLIENT_TYPE = "CLIENT_TYPE";


    public static final String SESSION_TYPE = "SESSION_TYPE";
    public static final String OPERATION_TYPE = "OPERATION_TYPE";


    public static final String SESSION_ACTIVITY = "SESSION_ACTIVITY";
    public static final String CREATE_SESSION_ACTIVITY = "CREATE_SESSION_ACTIVITY";
    public static final String CREATE_SESSION_ACTIVITY_DESC = "session created by";


    public static final String OPERATION_ACTIVITY = "OPERATION_ACTIVITY";

    public static final String CREATE_OPERATION_ACTIVITY = "CREATE_OPERATION_ACTIVITY";
    public static final String CREATE_OPERATION_ACTIVITY_DESC = "operation created by";

    public static final String START_OPERATION_ACTIVITY = "START_OPERATION_ACTIVITY";
    public static final String START_OPERATION_ACTIVITY_DESC = "operation started by";

    public static final String FINISH_OPERATION_ACTIVITY = "FINISH_OPERATION_ACTIVITY";
    public static final String FINISH_OPERATION_ACTIVITY_DESC = "operation finished by";



    public static final String URL_SHORTENER_API_ENDPOINT = "https://api.urlo.in/api/short-url";


    public static final String SMS_PROVIDER_API_URL = "https://api.1s2u.io/bulksms";
    public static final String SMS_PROVIDER_USER_NAME = "wrwrozengint023";
    public static final String SMS_PROVIDER_PASSWORD = "web97898";


    public static final String MESSAGE_CLIENT_NAME_TAG = "{clientName}";
    public static final String MESSAGE_PWA_LINK_TAG = "{pwaLink}";


    public static final String CAMPAIGN_TABLES = "CAMPAIGN_TABLES";
    public static final String SCENARIO_TABLES = "SCENARIO_TABLES";
    public static final String PROCESS_SCENARIO_TABLES = "PROCESS_SCENARIO_TABLES";


}
