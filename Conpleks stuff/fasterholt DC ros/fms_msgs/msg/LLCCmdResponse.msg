Header header

uint16 reponse_type			    #DEPLOY_RESPONSE, IRRIGATION_REQUEST_RESPONSE, ZONE_SETUP_RESPONSE, ZONE_SETUP_RESPONSE and IRRIGATION_DONE
uint8 machine_state				#MODE states in CanProtocol.h
uint8 llc_state					#LLC states in CanProtocol.h
uint8 error_code				#LLC errors in CanProtocol.h
string message