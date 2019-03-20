var events = [];

function findEvent (eventId) {
  return Events[findEventKey(eventId)];
}

function findEventKey (eventId) {
	// suche in allen Events nach dem Schlüssel
  for (var key = 0; key < events.length; key++) {
    if (events[key].id == eventId) {
      return key;
    }
  }
}

var eventService = {
  findAll(fn) {
    axios
      .get('/api/v1/events')
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  findById(id, fn) {
    axios
      .get('/api/v1/events/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  create(event_, fn) {
    axios
      .post('/api/v1/events', event_)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  update(id, event_, fn) {
    axios
      .put('/api/v1/events/' + id, event_)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  deleteEvent(id, fn) {
    axios
      .delete('/api/v1/events/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  }
}

var List = Vue.extend({
  template: '#event-list',
  data: function () {
    return {events: [], searchKey: ''};
  },
  computed: {
    filteredEvents() {
		// filter on paramter 'event'
      return this.events.filter((event_) => {
      	return event_.EventDescription.indexOf(this.searchKey) > -1
      	  || event_.Location.indexOf(this.searchKey) > -1
      	  || event_.Price.toString().indexOf(this.searchKey) > -1
      })
    }
  },
  mounted() {
    eventService.findAll(r => {this.events = r.data; events = r.data})
  }
});

var Event = Vue.extend({
  template: '#event',
  data: function () {
    return {event_: findEvent(this.$route.params.event_id)};
  }
  // no methods
});

var EventEdit = Vue.extend({
  template: '#event-edit',
  data: function () {
    return {event_: findEvent(this.$route.params.event_id)};
  },
  methods: {
    updateEvent: function () {
      eventService.update(this.event_.id, this.event_, r => router.push('/'))
    }
  }
});

var EventDelete = Vue.extend({
  template: '#event-delete',
  data: function () {
    return {event_: findEvent(this.$route.params.event_id)};
  },
  methods: {
    deleteEvent: function () {
      eventService.deleteEvent(this.event_.id, r => router.push('/'))
    }
  }
});

var AddEvent = Vue.extend({
  template: '#add-event',
  data() {
    return {
      event_: {EventDescription: '', Location: '', Price: 0}
    }
  },
  methods: {
    createEvent() {
      EventService.create(this.Event, r => router.push('/'))
    }
  }
});

var router = new VueRouter({
	routes: [
		{path: '/', component: List},
		{path: '/Event/:Event_id', component: Event, name: 'Event'},
		{path: '/add-Event', component: AddEvent},
		{path: '/Event/:Event_id/edit', component: EventEdit, name: 'Event-edit'},
		{path: '/Event/:Event_id/delete', component: EventDelete, name: 'Event-delete'}
	]
});

new Vue({
  router
}).$mount('#app')