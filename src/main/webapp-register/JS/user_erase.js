"UTF-8"

/**
 * Working with erase form. 
 */
function select_username_for_erase(username){
	document.getElementById('erase_form_input').value = '';
	document.getElementById('erase_form_input').value = username;
	submit(); 
}