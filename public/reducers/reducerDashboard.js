const INITIAL_STATE = {
  all : [],
  actual : {
    billingsTotal : 0.00
  },
  error : null
}

export default function(state = INITIAL_STATE) {
  let {all, actual} = state
  return state
}
