"UTF-8"

/**
 * Working with erase form. 
 */
function select_session_for_logout(session_id){
	document.getElementById('user_sessions_logout_data').value = '';
	document.getElementById('user_sessions_logout_data').value = session_id;
}