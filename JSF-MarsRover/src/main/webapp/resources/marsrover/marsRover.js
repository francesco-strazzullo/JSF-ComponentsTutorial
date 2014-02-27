/**
 * MarsRover Widget
 */
function MarsRover(id,xRows,yRows){
	this.cellSize = 40;
	this.roverSize = 25;
	this.gridXSize = this.cellSize*(xRows+1);
	this.gridYSize = this.cellSize*(yRows+1);
	this.paper = Raphael(id,this.gridXSize,this.gridYSize);
	this.xRows = xRows;
	this.yRows = yRows;
	
	
	/**
	 * draw the grid
	 */
	this.drawBoard = function(){
		//BASE
		this.paper.rect(this.cellSize,0,this.cellSize*(this.xRows),this.cellSize*(this.yRows)).attr({
			fill : "#FF7700",
			stroke : "#FF7700"
		});
		
		//Vertical lines
		for(var i = 1;i < this.xRows+2;i++){
			this.paper.path("M"+this.cellSize*i+","+0+"L"+this.cellSize*i+","+this.cellSize*(this.yRows+1)).attr({
				stroke : "#000000"
			});
		}
		//Horizontal lines
		for(var i = 0;i < this.yRows+1;i++){
			this.paper.path("M"+0+","+this.cellSize*i+"L"+this.cellSize*(this.xRows+1)*i+","+this.cellSize*i).attr({
				stroke : "#000000"
			});
		}
		
		//Col Numbers
		for(var i = 1;i < this.xRows+1;i++){
			this.paper.text(i*this.cellSize + this.cellSize/2,this.gridYSize - this.cellSize/2,i-1).attr({"font-size":24});
		}
		
		//Row Numbers
		for(var i = 1;i < this.yRows+1;i++){
			this.paper.text(this.cellSize/2,this.gridYSize-((i)*this.cellSize + this.cellSize/2),i-1).attr({"font-size":24});
		}
	};
	
	/**
	 * draw a rover in x,y position
	 */
	this.drawRover = function(x,y,direction,ordinal){
		
		var SQR3 = 1.7320;	       

		var h = (SQR3*this.roverSize)/2;
		//Print the ordinal
		this.paper.text((x+1)*this.cellSize+5,(this.yRows-y-1)*this.cellSize+6,ordinal).attr({"font-size":12});
		
		//Create the Rover Trianlge
		var x1 = (x+1)*this.cellSize + ((this.cellSize - this.roverSize)/2);
		var y1 = (this.yRows-y-1)*this.cellSize + ((this.cellSize - this.roverSize)/2) + h;

		var x2 = x1 + this.roverSize;
		var y2 = y1;

		var x3 = x1 + (this.roverSize/2);
		var y3 = y1 - h;

		var rover = this.paper.path("M"+x1+","+y1+"L"+x2+","+y2+"L"+x3+","+y3+"Z").attr({
			fill : "#FFFFFF",
			stroke : "#000000"
		});

		//Rotate the Triangle based on direction
		var rotation = 0;

		switch (direction) {
		case 'E':
			rotation = 90;
			break;
		case 'S':
			rotation = 180;
			break;
		case 'W':
			rotation = 270;
			break;
		}

		rover.rotate(rotation);
	};
	
}
