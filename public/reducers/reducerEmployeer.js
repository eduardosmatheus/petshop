import { CLEAR_ACTUAL_EMPLOYEER, FETCH_EMPLOYEERS, CREATE_EMPLOYEER,
  GET_EMPLOYEER, UPDATE_EMPLOYEER, DELETE_EMPLOYEER,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id : 0,
    name : '',
    cpf : '',
    phone : '',
    email : '',
    appointmentConfig: {
      id: 0,
      employeers_id: 0,
      entryTime: 0,
      lunchTime: 0,
      entryTimeAfterLunch: 0,
      homeTime: 0
    }
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_EMPLOYEERS:
      return {...state, all : action.payload }
      break
    case CREATE_EMPLOYEER:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_EMPLOYEER:
      all = all.map((ob) => {
        if(ob.id === actual.id) {
          return action.payload
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_EMPLOYEER:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_EMPLOYEER:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_EMPLOYEER:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
