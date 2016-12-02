const INITIAL_STATE = {
  views : {
    totalPayments : 570.00,
    appointmentsForToday : 5,
    appointmentsOpened : 8,
    appointmentsPerDay : [
      { monday : 5 },
      { tuesday : 9 },
      { wednesday : 100 },
      { thursday : 20 },
      { friday : 10 }
    ]
  },
  error : null
}

export default function(state = INITIAL_STATE) {
  let { views } = state
  return state
}
