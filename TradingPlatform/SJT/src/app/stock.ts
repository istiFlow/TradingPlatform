export interface Stock {
  id: number,
  symbol: String,
  open: number,
  high: number,
  low: number,
  price: number,
  volume: number,
  latestTradingDay: Date,
  previousClose: number,
  change: number,
  changePercent: String
}