import { CLEAR_ACTUAL_CUSTOMER, FETCH_CUSTOMERS, CREATE_CUSTOMER,
  GET_CUSTOMER, UPDATE_CUSTOMER, DELETE_CUSTOMER,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id : '',
    name : '',
    cpf : '',
    phone : '',
    email : ''
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_CUSTOMERS:
      return {...state, all : action.payload }
      break
    case CREATE_CUSTOMER:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_CUSTOMER:
      all = all.map((ob) => {
        if(ob.id === actual.id) {
          return action.payload
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_CUSTOMER:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_CUSTOMER:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_CUSTOMER:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
