import { CLEAR_ACTUAL_PRODUCT, FETCH_PRODUCTS, CREATE_PRODUCT,
  GET_PRODUCT, UPDATE_PRODUCT, DELETE_PRODUCT,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id : '',
    description : '',
    price: 0.0,
    stockAmount: 0
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_PRODUCTS:
      return {...state, all : action.payload }
      break
    case CREATE_PRODUCT:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_PRODUCT:
      all = all.map((ob) => {
        if(ob.id === actual.id) {
          return action.payload
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_PRODUCT:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_PRODUCT:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_PRODUCT:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
