$(document).ready(function(){
	$('#state').append($('<option>').text("Select State").val(0));
	$('#city').append($('<option>').text("Select City").val(0));
	$.getJSON('StateJSON', {ajax:true}, function(data){
		$.each(data, function(i, item){
			$('#state').append($('<option>').val(item.SID).text(item.SNAME));
		});
	});

	$('#state').change(function(){
		$.getJSON('CityJSON', {ajax:true, stateid:$('#state').val()}, function(data){
			$('#city').empty();
			$('#city').append($('<option>').text("Select City").val(0));
			$.each(data, function(i, item){
				$('#city').append($('<option>').val(item.CID).text(item.CNAME));
			});
		});
	});
});