window.onload = function() {
	var fileInput1 = document.getElementById('fileInput1');
	var fileDisplayArea1 = document.getElementById('fileDisplayArea1');

	fileInput1.addEventListener('change', function(e) {
		var file = fileInput1.files[0];
		var textType = /text.*/;

		if (file.type.match(textType)) {
			var reader = new FileReader();

			reader.onload = function(e) {
				fileDisplayArea1.value = reader.result;
			}

			reader.readAsText(file);	
		} else {
			fileDisplayArea1.value = "File not supported!"
		}
	});
		
		var fileInput2 = document.getElementById('fileInput2');
		var fileDisplayArea2 = document.getElementById('fileDisplayArea2');

		fileInput2.addEventListener('change', function(e) {
			var file = fileInput2.files[0];
			var textType = /text.*/;

			if (file.type.match(textType)) {
				var reader = new FileReader();

				reader.onload = function(e) {
					fileDisplayArea2.value = reader.result;
				}

				reader.readAsText(file);	
			} else {
				fileDisplayArea2.value = "File not supported!"
			}
		});
		
		var language = document.getElementById('language');
		var fileDisplayArea3 = document.getElementById('fileDisplayArea3');
		language.addEventListener('change', function(e) {
			fileDisplayArea3.value = language.value;
			
		});
		
}
