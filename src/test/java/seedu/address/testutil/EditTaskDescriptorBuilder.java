package seedu.address.testutil;

import seedu.address.logic.commands.EditTaskCommand;
import seedu.address.logic.commands.EditTaskCommand.EditTaskDescriptor;
import seedu.address.model.deadline.Deadline;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskDescription;

/**
 * A utility class to help with building EditTaskDescriptor objects.
 */
public class EditTaskDescriptorBuilder {

    private EditTaskCommand.EditTaskDescriptor descriptor;

    public EditTaskDescriptorBuilder() {
        descriptor = new EditTaskDescriptor();
    }

    public EditTaskDescriptorBuilder(EditTaskDescriptor descriptor) {
        this.descriptor = new EditTaskDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditTaskDescriptor} with fields containing {@code task}'s details
     */
    public EditTaskDescriptorBuilder(Task task) {
        descriptor = new EditTaskDescriptor();
        descriptor.setTaskDescription(task.getTaskDescription());
        descriptor.setTaskDeadline(task.getTaskDeadline());
    }

    /**
     * Sets the {@code TaskDescription} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withDescription(String description) {
        descriptor.setTaskDescription(new TaskDescription(description));
        return this;
    }

    /**
     * Sets the {@code Deadline} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withDeadline(String deadline) {
        descriptor.setTaskDeadline(new Deadline(deadline));
        return this;
    }

    public EditTaskDescriptor build() {
        return descriptor;
    }
}

