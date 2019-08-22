$(document).ready(function () {
	var currentLocation="Morón"
	
	$("#locations").val(currentLocation).selected
	
	function getWeather(location) {
		var weatherRequest = $.ajax({
			method: 'GET',
			url: 'api/getInfoLocation/' + location
		});
		weatherRequest.done(function(data) {
			processData(data);
		});
		weatherRequest.fail(function(xhr, status, error) {
			console.warn(error.message);
		});
	}
	
	function processData(data) {
		$("#location").text(data.name)
		$("#heading").text(data.weather.description)
		$("#temp-value").text(data.weather.tempDesc)
		
	}
	
	$("#locations").change(function(e){
		console.log(e.target.value)
		
		getWeather(e.target.value);
	})
	
	window.onload = function() {
		getWeather(currentLocation); 
	};
});