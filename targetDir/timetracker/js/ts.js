var n = 0;

webshim.setOptions('forms-ext', {
	// replaceUI: 'auto',
	types : 'date'
});
webshim.polyfill('forms forms-ext');

$(function() {

	$("#btnAdd").bind("click", function() {
		var div = $("<div />");
		div.html(GetDynamicTextBox(""));
		$("#fooBar").append(div);
	});
	$("#btnGet").bind("click", function() {
		var values = "";

		$("input[id=time]").each(function() {
			values += $(this).val() + "\n";
		});
		alert(values);
	});
	$("body").on("click", ".remove", function() {
		$(this).closest("div").remove();
	});
});
function GetDynamicTextBox(value) {
	n += 1;
	return 'task'
			+ '<input type="radio" value="task"  name="job'
			+ n
			+ '"/>'
			+ 'issue'
			+ '<input type="radio" value="issue" name="job'
			+ n
			+ '"/>'
			+ '<input id="time" name = "time" type="number" style="width:15%" placeholder="time" value = "'
			+ value
			+ '" />&nbsp;'
			+ '<input name = "comment" type="text" style="width:56%" placeholder="Task" value = "'
			+ value
			+ '" />&nbsp;'
			+ '<input type="button" value="X" name="x" style="width:7%"  class="remove" />'
}

function configureDropDownLists(ddl1, ddl2) {
	var oncall = [ 'Weekend support', 'Public Holiday Support -on-call' ];
	var project = [ 'Weekend support', 'Public Holiday Support -on-call' ];
	var compoff = [ 'Comp-off availed' ];

	switch (ddl1.value) {
	case 'oncall':
		ddl2.options.length = 0;
		for (i = 0; i < oncall.length; i++) {
			createOption(ddl2, oncall[i], oncall[i]);
		}
		break;
	case 'project':
		ddl2.options.length = 0;
		for (i = 0; i < project.length; i++) {
			createOption(ddl2, project[i], project[i]);
		}
		break;
	case 'compoff':
		ddl2.options.length = 0;
		for (i = 0; i < compoff.length; i++) {
			createOption(ddl2, compoff[i], compoff[i]);
		}
		break;
	default:
		ddl2.options.length = 0;
		break;
	}
	changetextbox();
}

function createOption(ddl, text, value) {
	var opt = document.createElement('option');
	opt.value = value;
	opt.text = text;
	ddl.options.add(opt);
}

function defaul() {

	document.getElementById("effort").style.display = "none";
	document.getElementById("comp").style.display = "none";

}

function changetextbox() {

	if (document.support.plan.value == 'oncall') {

		document.getElementById("effort").style.display = "block";

		document.getElementById("comp").style.display = "none";

	}

	else if (document.support.plan.value == 'project') {

		document.getElementById("effort").style.display = "block";
		document.getElementById("comp").style.display = "none";

	}

	else if (document.support.plan.value == 'compoff') {

		document.getElementById("effort").style.display = "none";

		document.getElementById("comp").style.display = "block";

		while (fooBar.lastChild) {

			fooBar.removeChild(fooBar.lastChild)

		}

		n = 0;

	}

	else {

		document.getElementById("comp").style.display = "none";
		document.getElementById("effort").style.display = "none";
	}

}