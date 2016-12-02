import { CLEAR_ACTUAL_APPOINTMENT, FETCH_APPOINTMENTS, CREATE_APPOINTMENT,
  GET_APPOINTMENT, UPDATE_APPOINTMENT, DELETE_APPOINTMENT,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id: '',
    employeer: {
      id : '',
      name : '',
      cpf : '',
      phone : '',
      email : '',
      appointmentConfig: {
        id: '',
        entryTime: 0,
        lunchTime: 0,
        entryTimeAfterLunch: 0,
        homeTime: 0,
      }
    },
    pet: {
      id: '',
      name: '',
      obs: '',
      especie: {
        id: '',
        name: ''
      },
      breed: {
        id: '',
        name:  ''
      },
      customer : {
        id : '',
        name : '',
        cpf : '',
        phone : '',
        email : ''
      }
    },
    date: '',
    entryTime: 0,
    outTime: 0,
    done: 0,
    obs: ''
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_APPOINTMENTS:
      return {...state, all : action.payload }
      break
    case CREATE_APPOINTMENT:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_APPOINTMENT:
      all = all.map((ob) => { 
        if(ob.id === action.payload) {
          return {...ob, done: 1}
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_APPOINTMENT:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_APPOINTMENT:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_APPOINTMENT:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
