	function getTuition(sClasstype) {
		subMoney=getSubIds().length * 300;
		typeMoney=getClasstypeMoney(sClasstype.val());
		allMoney=subMoney+typeMoney;
		return allMoney;
	}
	
	function getClasstypeMoney(classType) {
		switch (classType) {
		case '1':
			return 0;
		case '2':
			return 200;
		case '3':
			return 2000;
		}
	}

	function getSubIds() {
		subIds = new Array();
		i = 0;
		$.each($("input:checkbox:checked"), function() {
			subIds[i] = $(this).val();
			i++;
		});
		return subIds;
	}