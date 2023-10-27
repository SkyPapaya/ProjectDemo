//grid.js
function Grid(size = 4) {
    this.size = size;
    this.cells = [];
    this.init(size);
  }
  
  // prototype 设置方法
  Grid.prototype.init = function(size) {
    for (let row = 0; row < size; row++) {
      this.cells.push([]);
      for (let column = 0; column < size; column++) {
        this.cells[row].push(null);
      }
    }
  };
  
  Grid.prototype.add = function(tile) {
    this.cells[tile.row][tile.column] = tile;
  };
  