function TablePagination(table, pager) {
	this.self = this;
	self.maxPaddingPages = 0;
	self.currentPage = 0;
	self.numPerPage = 10;
	self.table = table; // $(this);
	self.pager = pager;
	self.numRows = self.table.find('tbody tr').length;
	self.numPages = Math.ceil(self.numRows / self.numPerPage);

	/*
	 * Main function for execute pagination. 
	 */
	this.paginate = function(numPerPage) {
		self.pager.html("");
		self.numPerPage = numPerPage || self.numPerPage;
		self.numRows = self.table.find('tbody tr').length;
		self.numPages = Math.ceil(self.numRows / self.numPerPage);

		self.printPageNumber("|&lt;", 0);
		self.printPreviousPageNumber("&lt;&lt;");
		for (var page = 0; page < self.numPages; page++) {
			self.printPageNumber(page + 1, page);
		}
		self.printNextPageNumber("&gt;&gt;");
		self.printPageNumber("&gt;|", self.numPages - 1);

		self.pager.find('div.page-number:nth(2)').addClass('active');
		
		self.table.bind('repaginate', self.repaginate);
		self.table.trigger('repaginate');
	};

	/*
	 * Paginates rows per page
	 */
	self.repaginate = function() {
		
		self.table.find('tbody tr').hide().slice(
				self.currentPage * self.numPerPage,
				(self.currentPage + 1) * self.numPerPage).show();

		self.pager.find('div.page-number').hide()
		var upperLimit = self.currentPage + self.maxPaddingPages + 2;
		var lowerLimit = self.currentPage - self.maxPaddingPages + 2;

		for (var i = 0; i < self.numPages + 4; i++) {
			var onRange = i <= upperLimit && i >= lowerLimit;
			var show = i == 0 || i == 1 || i == (self.numPages + 2)
					|| i == (self.numPages + 3) || onRange;
			if (show) {
				var s = 'div.page-number:nth(' + i + ')';
				self.pager.find(s).show();
			}
		}
	};

	/*
	 * Constraints the number of the page between 0 and the numPages -1
	 */
	self.validatePageNumber = function(pageNumber) {
		if (pageNumber >= self.numPages) {
			return pageNumber - 1;
		}
		if (pageNumber < 0) {
			return 0;
		}
		return pageNumber;
	}

	/*
	 * Prints a generic page number item.
	 */
	self.printPageNumber = function(text, page) {
		$('<div class="page-number">' + text + '</div>').bind('click', {
			newPage : page
		}, function(event) {
			self.currentPage = event.data['newPage'];
			self.table.trigger('repaginate');
			self.updateNextPageNumber(self.currentPage);
			$(this).addClass('active').siblings().removeClass('active');
		}).appendTo(self.pager).addClass('clickable');

	};

	/*
	 * Initializes the next page item.
	 */
	self.printNextPageNumber = function(text) {
		var newPager = self.pager.find('.page-number.next-page-number');
		var lastPager = self.pager.find('.page-number').last();
		var s = '<div class="page-number next-page-number clickable">'
		s += text + '</div>';

		if (!newPager.length) {
			$(s).bind(
					'click',
					{
						newPage : self.currentPage
					},
					function(event) {
						var nextPage = self
								.validatePageNumber(self.currentPage + 1);
						self.currentPage = nextPage;
						self.table.trigger('repaginate');
						var newCurrentPager = self.pager
								.find('.page-number:nth(' + (nextPage + 2)
										+ ')');
						newCurrentPager.addClass('active').siblings()
								.removeClass('active');

					}).appendTo(self.pager);
		}

	};

	/*
	 * Initializes the previous page item.
	 */
	self.printPreviousPageNumber = function(text) {

		var newPager = self.pager.find('.page-number.previous-page-number');
		var firstPager = self.pager.find('.page-number:nth(0)');
		var s = '<div class="page-number previous-page-number clickable">'
		s += text + '</div>';

		if (!newPager.length) {
			$(s).bind(
					'click',
					{
						newPage : self.currentPage
					},
					function(event) {
						var nextPage = self
								.validatePageNumber(self.currentPage - 1);
						self.currentPage = nextPage;
						self.table.trigger('repaginate');
						var newCurrentPager = self.pager
								.find('.page-number:nth(' + (nextPage + 2)
										+ ')');
						newCurrentPager.addClass('active').siblings()
								.removeClass('active');

					}).insertAfter(firstPager);
		}

	};

	/*
	 * Updates the next page item for every time you press a normal page item.
	 */
	self.updateNextPageNumber = function(page) {
		var newPager = self.pager.find('.page-number.next-page-number');
		var nextPage = self.validatePageNumber(page + 1);
		newPager.bind('click', {
			newPage : nextPage
		}, function(event) {
			self.printNextPageNumber();
		});
	};

	/*
	 * Updates the previous page item for every time you press a normal page
	 * item.
	 */
	self.updatePreviousPageNumber = function(page) {
		var newPager = self.pager.find('.page-number.previous-page-number');
		var nextPage = self.validatePageNumber(page - 1);
		newPager.bind('click', {
			newPage : nextPage
		}, function(event) {
			self.printPreviousPageNumber();
		});
	};

};

