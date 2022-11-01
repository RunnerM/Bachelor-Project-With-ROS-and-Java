Header 	  header

uint8 LLC_DISCONNECTED=0
uint8 LLC_CONNECTED=1

float32 hose_length
float32 velocity

bool pressure_sensor
bool stop_sensor
bool turbine_status

uint8 motor_1
uint8 motor_2
uint8 motor_3
uint8 plan_version

uint8 llc_state
uint8 llc_error
uint8 machine_state

float32 battery_voltage
float32 solar_cell_voltage

bool pre_irrigation
bool post_irrigation
uint8 current_zone_id  #0 when in pre/post irrigation

int32 start_time				#eposh of start time
int32 finish_time				#epoch of finish time
int32 original_finish_time	    #epoch 

int16 turbine_rpm